/*******************************************************************************
 * 	Copyright 2017 HuaWei Tld                                     
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
package org.openstack4j.openstack.scaling.domain.action;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("serial")
public final class ASScalingPolicyAction {
	public static class Execute implements ScalingPolicyAction {
		@JsonProperty
		private String action = "execute";
	}

	public static class Resume implements ScalingPolicyAction {
		@JsonProperty
		private String action = "resume";
	}
	
	public static class Pause implements ScalingPolicyAction {
		@JsonProperty
		private String action = "pause";
	}
}