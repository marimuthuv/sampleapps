package com.eop.api.sample.client;

import com.eop.api.ApiClient;

/**
 * Ravi K
 */
public class EopApp {

    public static void main(String[] args) {
    	ApiClient apiClient = new ApiClient();
    	 
        String offerId = "227904a8-38d0-4b96-a50f-6b4f21773da6";
        String response = apiClient.getOfferDetails(offerId);
        System.out.println(response);

        System.out.println("Get offer details - Completed");
    }

}
