package com.fumagalli.gerenciamento_pedidos.services;

import com.fumagalli.gerenciamento_pedidos.models.PedidoModel;
import com.fumagalli.gerenciamento_pedidos.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<PedidoModel> findAll(){
        return pedidoRepository.findAll();
    }

    public PedidoModel criarPedido(PedidoModel pedidoModel){
        return  pedidoRepository.save(pedidoModel);
    }

    public Optional<PedidoModel> buscarPorId(Long id){
        return pedidoRepository.findById(id);
    }

    public PedidoModel atualizar(long id, PedidoModel pedidoModel){
        PedidoModel model = pedidoRepository.findById(id).get();
        model.setData(pedidoModel.getData());
        model.setValorTotal(pedidoModel.getValorTotal());
        model.setStatus(pedidoModel.getStatus());

        return pedidoRepository.save(model);
    }

    public void deletar(Long id){
        pedidoRepository.deleteById(id);
    }

}
