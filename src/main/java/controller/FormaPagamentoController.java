package controller;

import model.Entity.FormaPagamento;
import model.Service.FormaPagamentoService;
import javax.persistence.EntityManager;

import java.util.List;

public class FormaPagamentoController {
    private FormaPagamentoService formaPagamentoService;

    public FormaPagamentoController(EntityManager em) {
        this.formaPagamentoService = new FormaPagamentoService(em);
    }

    public FormaPagamento adicionarFormaPagamento(FormaPagamento formaPagamento) {
        return formaPagamentoService.adicionarFormaPagamento(formaPagamento);
    }

    public FormaPagamento atualizarFormaPagamento(FormaPagamento formaPagamento) {
        return formaPagamentoService.atualizarFormaPagamento(formaPagamento);
    }

    public void removerFormaPagamento(Long id) {
        formaPagamentoService.removerFormaPagamento(id);
    }

    public FormaPagamento encontrarFormaPagamentoPorId(Long id) {
        return formaPagamentoService.encontrarFormaPagamentoPorId(id);
    }

    public List<FormaPagamento> listarTodasFormasPagamento() {
        return formaPagamentoService.listarTodasFormasPagamento();
    }
    public FormaPagamento findFormaPagamentoById(Long id) {
        return formaPagamentoService.findFormaPagamentoById(id); // supondo que você tenha um serviço de forma de pagamento
    }


}
