package org.zalando.pazuzu.docker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.zalando.pazuzu.exception.ServiceException;
import org.zalando.pazuzu.feature.FeatureService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/dockerfile")
public class DockerfileResource {

    private final FeatureService featureService;

    @Autowired
    public DockerfileResource(FeatureService featureService) {
        this.featureService = featureService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateDockerfile(@RequestParam(required = false) List<String> features) throws ServiceException {
        return featureService.generateDockerfile(features);
    }
}