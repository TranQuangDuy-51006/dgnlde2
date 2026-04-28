package re.dgnlde02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.dgnlde02.model.Artifact;

public interface ArtifactRepository extends JpaRepository<Artifact, Long> {

}
