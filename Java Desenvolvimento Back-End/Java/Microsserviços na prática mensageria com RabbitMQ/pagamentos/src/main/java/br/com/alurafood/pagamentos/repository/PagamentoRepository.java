package br.com.alurafood.pagamentos.repository;

import br.com.alurafood.pagamentos.model.Pagamento;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;


public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    Page<Pagamento> findAll(Pageable pageable);

}
