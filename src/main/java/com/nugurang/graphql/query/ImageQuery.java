package com.nugurang.graphql.query;

import com.nugurang.dto.ImageDto;
import com.nugurang.exception.NotFoundException;
import com.nugurang.service.ImageService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ImageQuery implements GraphQLQueryResolver {
    private final ImageService imageService;

    public Optional<ImageDto> getImage(Long id) throws NotFoundException {
        return Optional.ofNullable(imageService.getImage(id)).map(entity -> entity.toDto());
    }

    public Optional<ImageDto> getImageByAddress(String address) throws NotFoundException {
        return Optional.ofNullable(imageService.getImage(address)).map(entity -> entity.toDto());
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    
    public ImageQuery(final ImageService imageService) {
        this.imageService = imageService;
    }
    //</editor-fold>
}
