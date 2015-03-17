/**
 * 
 */
package com.eop.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.eop.api.io.Geo;
import com.eop.api.io.GeoAttribute;
import com.eop.api.io.Media;
import com.eop.api.io.Offer;
import com.eop.api.io.Product;
import com.eop.api.io.RedemptionAddress;
import com.eop.api.io.SearchRequest;
import com.eop.api.offerdetail.gen.GetOfferDetailsResponse;
import com.eop.api.offerdetail.gen.GetOfferDetailsResponse.Return.DetailOfferData;
import com.eop.api.offerdetail.gen.GetOfferDetailsResponse.Return.DetailOfferData.OfferMedia;
import com.eop.api.offerdetail.gen.GetOfferDetailsResponse.Return.DetailOfferData.OfferMedia.OfferImage;
import com.eop.api.offerdetail.gen.GetOfferDetailsResponse.Return.DetailOfferData.OfferMedia.OfferImage.Entry;
import com.eop.api.offerdetail.gen.GetOfferDetailsResponse.Return.DetailOfferData.Products;
import com.eop.api.offerdetail.gen.GetOfferDetailsResponse.Return.DetailOfferData.RedemptionAddresses;
import com.eop.api.offerdetail.gen.GetOfferDetailsResponse.Return.DetailOfferData.SourceGeos;
import com.eop.api.search.gen.BrowseOffersResponse;
import com.eop.api.search.gen.BrowseOffersResponse.Return.OfferData;
import com.eop.api.spec.IOffersApi;
import com.google.gdata.util.common.base.StringUtil;

/**
 * @author Ravi K
 */
public class OfferApi implements IOffersApi {

    private ApiClient apiclient = new ApiClient();

    public Offer getOfferDetail(String offerId) {
        GetOfferDetailsResponse offerDetail = apiclient.getOfferDetail(offerId);
        Offer offer = new Offer();

        if (offerDetail != null) {
            DetailOfferData detailOfferData = offerDetail.getReturn().getDetailOfferData();
            offer.setTitle(StringUtil.unescapeHTML(detailOfferData.getOfferDisplay().getHeadline()));
            offer.setSubTitle(StringUtil.unescapeHTML(detailOfferData.getOfferDisplay().getSubtitle()));
            offer.setLongDescription(StringUtil.unescapeHTML(detailOfferData.getOfferDisplay().getLongDescription()));
            offer.setTerms(detailOfferData.getOfferDisplay().getTerms());
            offer.setLanguage(detailOfferData.getLanguage());
            offer.setOfferId(detailOfferData.getOfferId());
            offer.setMerchantName(detailOfferData.getMerchant().getName());
            offer.setTags(getCommaSeparatedString(detailOfferData.getTag()));
            offer.setMedia(getMedia(detailOfferData.getOfferMedia()));
            
            offer.setCategory(getCommaSeparatedCategory(detailOfferData.getCategory()));
            offer.setProducts(getProducts(detailOfferData.getProducts()));
            offer.setRedemptionAddresses(getRedemptionAddress(detailOfferData.getRedemptionAddresses()));
            offer.setSourceGeos(getSourceGeo(detailOfferData.getSourceGeos()));
            
            offer.setTagTier(Arrays.asList(detailOfferData.getTagTier()));
            offer.setTagPrice(Arrays.asList(detailOfferData.getTagOfferPrice()));
            offer.setTagCategory(Arrays.asList(detailOfferData.getTagCategory()));
            offer.setRedemptionTypes(detailOfferData.getRedemptionCodeType());
            
            offer.setBookingStart(detailOfferData.getBookingStart());
            offer.setBookingEnd(detailOfferData.getBookingEnd());
            offer.setDisplayStart(detailOfferData.getDisplayStart());
            offer.setDisplayEnd(detailOfferData.getDisplayEnd());
            
            if (detailOfferData.getComplimentaryPriceText() == null || "".equals(detailOfferData.getComplimentaryPriceText().trim())) {
                offer.setPrice(""+detailOfferData.getPrice() + " "+ detailOfferData.getCurrencyCode());
            }else {
                offer.setPrice(detailOfferData.getComplimentaryPriceText());
            }
        }
        return offer;
    }

    private List<Geo> getSourceGeo(SourceGeos sourceGeos) {

    	if(sourceGeos == null || sourceGeos.getGeo() == null || sourceGeos.getGeo().size() <= 0 ) return null;
     	
    	List<Geo> geoList = new ArrayList<Geo>();  
    	
    	for (com.eop.api.offerdetail.gen.GetOfferDetailsResponse.Return.DetailOfferData.SourceGeos.Geo geo : sourceGeos.getGeo()) {
    		Geo aGeo = new Geo();
    		if (geo.getCity() != null)
    			aGeo.setCity(new GeoAttribute(geo.getCity().getDisplayText(), geo.getCity().getCode()));
    		if (geo.getCountry() != null)
    			aGeo.setCountry(new GeoAttribute(geo.getCountry().getDisplayText(), geo.getCountry().getCode()));
    		if (geo.getRegion() != null)
    			aGeo.setRegion(new GeoAttribute(geo.getRegion().getDisplayText(), geo.getRegion().getCode()));
			geoList.add(aGeo);
    	}
    	return geoList;
    	
	}

	private List<RedemptionAddress> getRedemptionAddress(RedemptionAddresses redemptionAddresses) {

    	if(redemptionAddresses == null || redemptionAddresses.getRedemptionAddress() == null ||  redemptionAddresses.getRedemptionAddress().size() >=0) return null;

    	List<RedemptionAddress> redemptionAddressesList = new ArrayList<RedemptionAddress>();  
    	for (com.eop.api.offerdetail.gen.GetOfferDetailsResponse.Return.DetailOfferData.RedemptionAddresses.RedemptionAddress address : redemptionAddresses.getRedemptionAddress()) {
    		RedemptionAddress  ra =  new RedemptionAddress();
    		ra.setCity(address.getCity());
    		ra.setCountry(address.getCountry());
    		ra.setLatitude(address.getLatitude());
    		ra.setLongitude(ra.getLongitude());
    		ra.setName(address.getName());
    		ra.setPostalCode(address.getPostalCode());
    		ra.setState(address.getState());
    		ra.setStreet(address.getStreet());
    		ra.setStreet2(address.getStreet2());
    		redemptionAddressesList.add(ra);
    	}    	
    	
    	return redemptionAddressesList;
	}

	private List<Product> getProducts(Products products) {

    	if(products == null || products.getProduct() == null || products.getProduct().size() <= 0 ) return null;
     	
    	List<Product> productList = new ArrayList<Product>();  
    	
    	for (com.eop.api.offerdetail.gen.GetOfferDetailsResponse.Return.DetailOfferData.Products.Product product : products.getProduct()) {
			Product aProduct = new Product();
			aProduct.setCode(product.getCode());
			aProduct.setImageUrl(product.getImageUrl());
			productList.add(aProduct);
    	}
    	return productList;
	}

	private String getCommaSeparatedCategory(List<String> category) {

    	if (category == null) return null;
    	StringBuffer  buffer = new StringBuffer();
    	
    	for (String aCategory : category) {
			buffer.append(aCategory);
		}
    	
    	return buffer.toString();
	}

	private Media getMedia(OfferMedia offerMedia) {

        Media media = new Media();

        if (offerMedia != null) {
            OfferImage offerImage = offerMedia.getOfferImage();
            List<Entry> entry = offerImage.getEntry();
            for (Entry aImage : entry) {
                if (aImage.getKey().equals("LARGE")) {
                    media.setOfferImageUrl(aImage.getValue().getItem().getImageUrl());
                    media.setOfferImageAltText(aImage.getValue().getItem().getAltText());
                }
                if (aImage.getKey().equals("MERCHANT_LOGO")) {
                    media.setMerchantImageUrl(aImage.getValue().getItem().getImageUrl());
                    media.setMerchantAltText(aImage.getValue().getItem().getAltText());
                }
            }
        }
        return media;
    }

    public List<Offer> searchOffers(SearchRequest searchRequest) {

        List<Offer> offers = new ArrayList<Offer>();
        BrowseOffersResponse searchOffer = apiclient.searchOffer(searchRequest);

        if (searchOffer != null) {
            List<OfferData> offerDatas = searchOffer.getReturn().getOfferData();
            for (OfferData offerData : offerDatas) {
                Offer offer = new Offer();
                offer.setTitle(StringUtil.unescapeHTML(offerData.getHeadline()));
                offer.setSubTitle(StringUtil.unescapeHTML(offerData.getSubtitle()));
                offer.setLanguage(offerData.getLanguage());
                offer.setOfferId(offerData.getOfferId());
                offer.setMerchantName(offerData.getMerchant().getName());
                offer.setMedia(getBrowseOfferMedia(offerData.getOfferMedia()));
                
                offer.setTagTier(Arrays.asList(offerData.getTagTier()));
                offer.setTagPrice(Arrays.asList(offerData.getTagOfferPrice()));
                offer.setTagCategory(Arrays.asList(offerData.getTagCategory()));
                
                offers.add(offer);
            }
        }

        return offers;
    }

    private Media getBrowseOfferMedia(com.eop.api.search.gen.BrowseOffersResponse.Return.OfferData.OfferMedia offerMedia) {
        
        Media media = new Media();

        if (offerMedia != null) {
            com.eop.api.search.gen.BrowseOffersResponse.Return.OfferData.OfferMedia.OfferImage offerImage = offerMedia.getOfferImage();
            List<com.eop.api.search.gen.BrowseOffersResponse.Return.OfferData.OfferMedia.OfferImage.Entry> entry = offerImage.getEntry();
            for (com.eop.api.search.gen.BrowseOffersResponse.Return.OfferData.OfferMedia.OfferImage.Entry aImage : entry) {
                if (aImage.getKey().equals("LARGE")) {
                    media.setOfferImageUrl(aImage.getValue().getItem().getImageUrl());
                    media.setOfferImageAltText(aImage.getValue().getItem().getAltText());
                }
                if (aImage.getKey().equals("MERCHANT_LOGO")) {
                    media.setMerchantImageUrl(aImage.getValue().getItem().getImageUrl());
                    media.setMerchantAltText(aImage.getValue().getItem().getAltText());
                }
            }
        }
        return media;
    }

    private String getCommaSeparatedString(List<String> list) {

        if (list == null) return "";

        StringBuilder result = new StringBuilder();
        for (String string : list) {
            result.append(string);
            result.append(",");
        }
        return result.length() > 0 ? result.substring(0, result.length() - 1) : "";
    }

    public String getRecentOffers(Integer hours) {
        return null;
    }

}
