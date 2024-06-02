package model.Service;

import model.Entity.FormaPagamento;
import model.Repository.FormaPagamentoRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class FormaPagamentoService {
    private  FormaPagamentoRepository formaPagamentoRepository;

    public FormaPagamentoService(EntityManager em) {
        this.formaPagamentoRepository = new FormaPagamentoRepository(em);
    }

    public FormaPagamento adicionarFormaPagamento(FormaPagamento formaPagamento) {
        return (FormaPagamento) formaPagamentoRepository.create(formaPagamento);
    }

    public FormaPagamento atualizarFormaPagamento(FormaPagamento formaPagamento) {
        return (FormaPagamento) formaPagamentoRepository.update(formaPagamento);
    }

    public void removerFormaPagamento(Long id) {
        formaPagamentoRepository.delete(id);
    }

    public FormaPagamento encontrarFormaPagamentoPorId(Long id) {
        return (FormaPagamento) formaPagamentoRepository.findById(id);
    }

    public List<FormaPagamento> listarTodasFormasPagamento() {
        return formaPagamentoRepository.findAll();
    }
    public FormaPagamento findFormaPagamentoById(Long id) {
        return formaPagamentoRepository.findById(id);
    }
}
