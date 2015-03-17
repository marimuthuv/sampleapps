package com.eop.api.sample.client;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.eop.api.ApiClient;
import com.eop.api.OfferApi;
import com.eop.api.io.Geo;
import com.eop.api.io.GeoAttribute;
import com.eop.api.io.Offer;
import com.eop.api.io.SearchRequest;


/**
 * Test cases for EOP application.
 */
public class EopAppTest {
  
    private ApiClient apiClient = new ApiClient();
    
    @Test
    public void testGetOfferDetails() {
        String offerId = "afe5c6f2-efa5-4e68-84f0-6aa86738a32b";
        String response = apiClient.getOfferDetails(offerId);
        System.out.println(response);
    }
    
    @Test
    public void testGetRedemptionCodes() {
        String offerId = "ec71320f-9f5b-458d-9aba-68219ba6c6ce";
        String response = apiClient.getRedemptionCodes(offerId);
        System.out.println(response);
    }

    @Test
    public void testGetOfferInventory() {
        String offerId = "fe632773-01ce-4d8d-b348-78bc4a1863fc";
        String response = apiClient.getOfferInventory(offerId);
        System.out.println(response);
    }
    
    @Test
    public void testUpdateOfferInventory() {
        String offerId = "A96e189d-6e85-45d1-8bda-7221b0f04dc6";
        int redeemedQuantity = 1;
        String response = apiClient.updateInventory(offerId, redeemedQuantity);
        System.out.println(response);
    }

    
    @Test
    public void testGetRecentOffers() {
        Integer hours = 24;
        String response = apiClient.getRecentOffers(hours);
        System.out.println(response);
    }
    
    @Test
    public void testSearchOffers() {
        
      String searchKey = "limited";  
      SearchRequest searchRequest = new SearchRequest();
      searchRequest.setPlatform("priceless");
      searchRequest.setKeywords(searchKey);

      String response = apiClient.getSearchOffers(searchRequest);
      System.out.println(response);
    }

    
    @Test
    public void testSearchOffersByProductCodes() {
        
      String searchKey = "";  

      List<String> productCode = new ArrayList<String>();
      productCode.add("MWE");
      productCode.add("MPL");
      
      
      SearchRequest searchRequest = new SearchRequest();
      searchRequest.setPlatform("priceless");
      searchRequest.setKeywords(searchKey);
      searchRequest.setProductCode(productCode);

      String response = apiClient.getSearchOffers(searchRequest);
      System.out.println(response);
    }
    
    
    @Test
    public void testSearchOffersByTagCategory() {
        
      String searchKey = "offer";  
      List<String> tagCategory = new ArrayList<String>();
      tagCategory.add("SHOP");
      
      SearchRequest searchRequest = new SearchRequest();
      searchRequest.setPlatform("priceless");
      searchRequest.setKeywords(searchKey);
      searchRequest.setTagCategory(tagCategory);

      String response = apiClient.getSearchOffers(searchRequest);
      System.out.println(response);
    }
    
    @Test
    public void testSearchOffersByGeo() {
        
      List<Geo> sourceGeos = new ArrayList<Geo>();
      Geo geo = new Geo();
      geo.setCity(new GeoAttribute("newyork"));
      sourceGeos.add(geo);
      
      SearchRequest searchRequest = new SearchRequest();
      searchRequest.setPlatform("priceless");
      searchRequest.setSourceGeos(sourceGeos);

      String response = apiClient.getSearchOffers(searchRequest);
      System.out.println(response);
    }
    
    @Test
    public void testSearchOffersByMerchant() {
        
      List<Geo> sourceGeos = new ArrayList<Geo>();
      Geo geo = new Geo();
      geo.setCity(new GeoAttribute("newyork"));
      sourceGeos.add(geo);
      
      
      SearchRequest searchRequest = new SearchRequest();
      searchRequest.setPlatform("priceless");
      searchRequest.setSourceGeos(sourceGeos);
      searchRequest.setMerchantName("GILT");
      
      String response = apiClient.getSearchOffers(searchRequest);
      System.out.println(response);
    }
    
    @Test
    public void testSearchOffers1() {
        
      List<Geo> sourceGeos = new ArrayList<Geo>();
      Geo geo = new Geo();
      geo.setCity(new GeoAttribute("newyork"));
      sourceGeos.add(geo);
      
      
      SearchRequest searchRequest = new SearchRequest();
      searchRequest.setPlatform("priceless");
      searchRequest.setSourceGeos(sourceGeos);
      searchRequest.setMerchantName("GILT");
      
      OfferApi api = new OfferApi();
      
      List<Offer> response = api.searchOffers(searchRequest);
      System.out.println(response.get(0).getMedia().getOfferImageUrl());
    }
}
