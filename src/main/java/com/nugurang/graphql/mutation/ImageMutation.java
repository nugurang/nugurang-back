package com.nugurang.graphql.mutation;

import com.nugurang.dto.ImageDto;
import com.nugurang.service.ImageService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Service;

@Service
public class ImageMutation implements GraphQLMutationResolver {
    private final ImageService imageService;

    public ImageDto createImage(String address) {
        return imageService.createImage(address).toDto();
    }

    public Long deleteImage(Long id) {
        imageService.deleteImage(id);
        return id;
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public ImageMutation(final ImageService imageService) {
        this.imageService = imageService;
    }
    //</editor-fold>
}
