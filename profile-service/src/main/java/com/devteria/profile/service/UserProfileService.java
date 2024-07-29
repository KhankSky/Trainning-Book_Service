package com.devteria.profile.service;

import com.devteria.profile.dto.request.ProfileCreationRequest;
import com.devteria.profile.dto.response.UserProfileReponse;
import com.devteria.profile.entity.UserProfile;
import com.devteria.profile.repository.UserProfileRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserProfileService {
    UserProfileRepository userProfileRepository;
    ModelMapper modelMapper;

    public UserProfileReponse createProfile(ProfileCreationRequest request) {
        UserProfile userProfile = modelMapper.map(request, UserProfile.class);
        userProfile = userProfileRepository.save(userProfile);

        return modelMapper.map(userProfile, UserProfileReponse.class);
    }

    public UserProfileReponse getProfile(String id) {
        UserProfile userProfile =
                userProfileRepository.findById(id).orElseThrow(() -> new RuntimeException("Profile not found"));

        return modelMapper.map(userProfile, UserProfileReponse.class);
    }
}
