package com.fumagalli.gerenciamento_pedidos.controllers;

import com.fumagalli.gerenciamento_pedidos.models.PedidoModel;
import com.fumagalli.gerenciamento_pedidos.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoModel>> findAll(){
        List<PedidoModel> requeste = pedidoService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    public ResponseEntity<PedidoModel> criarPedido(@RequestBody PedidoModel pedidoModel){
        PedidoModel novo = pedidoService.criarPedido(pedidoModel);
        return ResponseEntity.status(201).body(novo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPedido (@PathVariable Long id){
        pedidoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoModel> buscarPorIdPedido(@PathVariable Long id){
        Optional<PedidoModel> pedido = pedidoService.buscarPorId(id);

        if(pedido.isPresent()){
            return ResponseEntity.ok(pedido.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoModel> atualizarPedido(@PathVariable Long id, @RequestBody PedidoModel pedidoModel){
        PedidoModel atualizado = pedidoService.atualizar(id, pedidoModel);
        return ResponseEntity.ok().body(atualizado);
    }
}
