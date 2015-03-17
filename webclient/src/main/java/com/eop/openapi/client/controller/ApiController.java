/**
 * 
 */
package com.eop.openapi.client.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eop.api.io.Geo;
import com.eop.api.io.GeoAttribute;
import com.eop.api.io.SearchRequest;
import com.eop.api.spec.IOffersApi;

/**
 * @author Ravi K
 */
@Controller
public class ApiController {

	@Autowired
	private IOffersApi offersApi;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String landingPage(ModelMap modelMap, HttpServletResponse response) {
		modelMap.addAttribute("tab", "home");
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String apphome(ModelMap modelMap, @CookieValue(value = "explorecity", defaultValue = "") String exploreCity) {
		modelMap.addAttribute("title", "Welcome to EOP");

		SearchRequest request = new SearchRequest();
		request.setLanguage("en_US");
		if (!"".equals(exploreCity)) 
        	request.setSourceGeos(getSourceGeo(exploreCity));
		
		modelMap.addAttribute("offers", offersApi.searchOffers(request));

		SearchRequest request1 = new SearchRequest();
		List<String> tierList = new ArrayList<String>();
		tierList.add("EXPERIENCE");
		request1.setLanguage("en_US");
		request1.setTagTier(tierList);
		request1.setItemsPerPage(5);
		if (!"".equals(exploreCity)) 
        	request1.setSourceGeos(getSourceGeo(exploreCity));
		
		modelMap.addAttribute("experiences", offersApi.searchOffers(request1));

		modelMap.addAttribute("tab", "home");
		return "explore";

	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String dashboard(ModelMap map, @RequestParam String offerId) {
		System.out.println("request with offer Id :" + offerId);
		map.addAttribute("offer", offersApi.getOfferDetail(offerId));
		map.addAttribute("tab", "detail");
		return "detail";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchOffers(ModelMap map,
			@RequestParam(required = false) String query,
			@RequestParam(required = false) String platform,
			@RequestParam(required = false) String category,
			@RequestParam(required = false) String language,
			@RequestParam(required = false) String city,
			@RequestParam(required = false) String country,
			@RequestParam(required = false) String tags,
			@RequestParam(required = false) String merchant,
			@RequestParam(required = false) String tagTier, 
			@RequestParam(required = false) String cardType) {
		
		List<Geo> geos = null;
		List<String> tagList = null;
		List<String> tagTierList = null;
		List<String> cardTypeList = null;

		if (StringUtils.isEmpty(platform))
			platform = null;
		if (StringUtils.isEmpty(category))
			category = null;
		if (StringUtils.isEmpty(language))
			language = null;
		if (StringUtils.isEmpty(merchant))
			merchant = null;

		if (!StringUtils.isEmpty(tags)) {
			tagList = new ArrayList<String>();
			tagList.add(tags);
		}
		;

		if (!StringUtils.isEmpty(city) || !StringUtils.isEmpty(country)) {
			geos = new ArrayList<Geo>();
			Geo geo = new Geo();
			if (!StringUtils.isEmpty(city))
				geo.setCity(new GeoAttribute(city));
			if (!StringUtils.isEmpty(country))
				geo.setCountry(new GeoAttribute(country));
			geos.add(geo);
		}

		if (!StringUtils.isEmpty(tagTier)) {
			tagTierList = new ArrayList<String>();
			tagTierList.add(tagTier);
		}
		
		if (!StringUtils.isEmpty(cardType)) {
			cardTypeList = new ArrayList<String>();
			cardTypeList.add(cardType);
		}

		
		System.out.println("request with " + query);
		if (query != null) {

			List<String> categoryList = new ArrayList<String>();
			categoryList.add(category);

			SearchRequest request = new SearchRequest();
			request.setKeywords(query);
			request.setPlatform(platform);
			request.setCategory(categoryList);
			request.setLanguage(language);
			request.setMerchantName(merchant);
			request.setSourceGeos(geos);
			request.setTag(tagList);
			request.setTagTier(tagTierList);
			request.setProductCode(cardTypeList);

			map.addAttribute("offers", offersApi.searchOffers(request));
			map.addAttribute("search", "true");
		}
		map.addAttribute("tab", "search");
		return "search";

	}

	@RequestMapping(value = "/explore", method = RequestMethod.GET)
    public String explore(ModelMap map, @CookieValue(value = "explorecity", defaultValue = "") String exploreCity) {
    	 
    	SearchRequest request = new SearchRequest();
        request.setLanguage("en_US");
        request.setItemsPerPage(40);
        if (!"".equals(exploreCity)) 
        	request.setSourceGeos(getSourceGeo(exploreCity));
        

        map.addAttribute("offers", offersApi.searchOffers(request));
        map.addAttribute("tab", "explore");
        return "explore";
	}
	
    private List<Geo> getSourceGeo(String exploreCity) {
    	List<Geo> geos = null;
    	if (!StringUtils.isEmpty(exploreCity) ) {
            geos = new ArrayList<Geo>();
            Geo geo = new Geo();
            if (!StringUtils.isEmpty(exploreCity)) geo.setCity(new GeoAttribute(exploreCity));
            geos.add(geo);
        }
    	return geos;
    }

	@RequestMapping(value = "/explore/{category}", method = RequestMethod.GET)
	public String exploreCategory(ModelMap map,
			@PathVariable("category") String category, @CookieValue(value = "explorecity", defaultValue = "") String exploreCity) {
		map.addAttribute("title", StringUtils.capitalize(category) + " offers");

		List<String> categoryList = new ArrayList<String>();
		categoryList.add(category);
		SearchRequest request = new SearchRequest();
		request.setLanguage("en_US");
		request.setCategory(categoryList);
		request.setItemsPerPage(40);
		if (!"".equals(exploreCity)) 
        	request.setSourceGeos(getSourceGeo(exploreCity));
		
		map.addAttribute("offers", offersApi.searchOffers(request));
		map.addAttribute("tab", category);
		return "explore";
	}

	@RequestMapping(value = "/premium", method = RequestMethod.GET)
	public String premium(ModelMap map) {
		SearchRequest request = new SearchRequest();
		List<String> tierList = new ArrayList<String>();
		tierList.add("EXPERIENCE");
		request.setLanguage("en_US");
		request.setTagTier(tierList);
		request.setItemsPerPage(40);

		map.addAttribute("offers", offersApi.searchOffers(request));
		map.addAttribute("premium", "premium");
		return "explore";
	}

}
