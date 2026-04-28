package re.dgnlde02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import re.dgnlde02.model.Artifact;
import re.dgnlde02.repository.ArtifactRepository;

@Service
public class ArtifactService {
    @Autowired
    private ArtifactRepository repo;

    public Page<Artifact> getAll (int page){
        return repo.findAll(PageRequest.of(page, 5));
    }

    public void save(Artifact artifact){
        repo.save(artifact);
    }

    public Artifact findById(Long id){
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}
