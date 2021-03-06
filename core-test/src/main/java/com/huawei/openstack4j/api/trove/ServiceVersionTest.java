/*******************************************************************************
 * 	Copyright 2018 Huawei Technologies Co., Ltd.                                     
 * 	                                                                                 
 * 	Licensed under the Apache License, Version 2.0 (the "License"); you may not      
 * 	use this file except in compliance with the License. You may obtain a copy of    
 * 	the License at                                                                   
 * 	                                                                                 
 * 	    http://www.apache.org/licenses/LICENSE-2.0                                   
 * 	                                                                                 
 * 	Unless required by applicable law or agreed to in writing, software              
 * 	distributed under the License is distributed on an "AS IS" BASIS, WITHOUT        
 * 	WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the         
 * 	License for the specific language governing permissions and limitations under    
 * 	the License.                                                                     
 *******************************************************************************/
package com.huawei.openstack4j.api.trove;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.huawei.openstack4j.api.AbstractTest;
import com.huawei.openstack4j.openstack.common.ServiceVersion;
import com.huawei.openstack4j.openstack.common.ServiceVersion.ServiceStatus;

import okhttp3.mockwebserver.RecordedRequest;

@Test(suiteName = "Trove/version", enabled = true)
public class ServiceVersionTest extends AbstractTest {

	@Test
	public void testGetVersion() throws IOException, InterruptedException {
		respondWith("/trove/get_service_version_response.json");
		ServiceVersion serviceVersion = osv3().trove().versions().get("version-id");

		RecordedRequest request = server.takeRequest();
		Assert.assertEquals(request.getPath(), "/version-id");
		Assert.assertEquals(request.getMethod(), "GET");

		Assert.assertEquals(serviceVersion.getId(), "v1.0");
		Assert.assertEquals(serviceVersion.getStatus(), ServiceStatus.CURRENT);
		Assert.assertEquals(serviceVersion.getUpdated().getTime(), 1490290442000L);
		Assert.assertEquals(serviceVersion.getLinks().size(), 1);
		Assert.assertEquals(serviceVersion.getLinks().get(0).getHref(), "");
		Assert.assertEquals(serviceVersion.getLinks().get(0).getRel(), "self");
	}

	@Test
	public void testListVersion() throws IOException, InterruptedException {
		respondWith("/trove/list_service_version_response.json");
		List<ServiceVersion> versions = osv3().trove().versions().list();

		RecordedRequest request = server.takeRequest();
		Assert.assertEquals(request.getPath(), "/");
		Assert.assertEquals(request.getMethod(), "GET");

		Assert.assertEquals(versions.size(), 2);

		ServiceVersion serviceVersion = versions.get(1);

		Assert.assertEquals(serviceVersion.getId(), "v1.0");
		Assert.assertEquals(serviceVersion.getStatus(), ServiceStatus.CURRENT);
		Assert.assertEquals(serviceVersion.getUpdated().getTime(), 1490290442000L);
		Assert.assertEquals(serviceVersion.getLinks().size(), 1);
		Assert.assertEquals(serviceVersion.getLinks().get(0).getHref(), "");
		Assert.assertEquals(serviceVersion.getLinks().get(0).getRel(), "self");
	}

	@Override
	protected Service service() {
		return Service.DATABASE;
	}

}
