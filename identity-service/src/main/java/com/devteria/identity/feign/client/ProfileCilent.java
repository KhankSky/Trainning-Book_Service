package com.devteria.identity.feign.client;

import com.devteria.identity.feign.dto.request.ProfileCreationRequest;
import com.devteria.identity.feign.dto.response.UserProfileResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "profile-service", url = "${app.services.profile}")
public interface ProfileCilent {
    @PostMapping(value = "/users",produces = MediaType.APPLICATION_JSON_VALUE)
    UserProfileResponse createProfile(@RequestBody ProfileCreationRequest request);
}
