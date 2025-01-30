package mad.voll.api.medico;

import aj.org.objectweb.asm.commons.Remapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    List<Medico> findAllByOrderByNome(Pageable paginacao);

    Page<Medico> findAllByAtivoTrue(Pageable paginacao);
}
