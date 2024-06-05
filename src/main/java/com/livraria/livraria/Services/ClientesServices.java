package com.livraria.livraria.Services;

import com.livraria.livraria.Entity.Clientes;
import com.livraria.livraria.Repository.ClientesRepository;
import com.livraria.livraria.dto.ClienteDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesServices {

    ClientesRepository clientesRepository;

    ModelMapper modelMapper;

    @Autowired
     private EmailServices emailServices;

    public ClientesServices(ClientesRepository clientesRepository,ModelMapper modelMapper) {
        this.clientesRepository = clientesRepository;
        this.modelMapper = modelMapper;
    }

    public void cadastrarClientes(Clientes clientes) {
        clientesRepository.save(clientes);
    }

    public ClienteDTO buscarPeloIdClientes(Long id) {
        Clientes clientes = clientesRepository.findById(id).orElseThrow();
        ClienteDTO clienteDTO = modelMapper.map(clientes,ClienteDTO.class);

        clienteDTO.setEndereco(clientes.getEndereco());

        emailServices.enviarEmailTexto(clientes.getEmail(),
                "Bem-vindo(a) ao universo literário da Livraria Class!",
                "Prezado(a) Cliente(a),\n" +
                        "\n" +
                        "Com imensa alegria, te recebemos na Livraria Class! Agradecemos por se cadastrar e por fazer parte da nossa comunidade apaixonada por livros.\n" +
                        "\n" +
                        "Acreditamos que cada leitor é único e que a leitura é uma jornada transformadora. Por isso, nos dedicamos a oferecer uma seleção cuidadosamente de livros para todos os gostos e estilos.\n" +
                        "\n" +
                        "Para tornar sua experiência ainda mais especial, preparamos alguns presentes para você:\n" +
                        "\n" +
                        "10% de desconto em sua primeira compra online: Utilize o código LIVROPRIMEIRO no checkout.\n" +
                        "Your Name: Um exemplar gratuito do nosso livro mais querido, para você se encantar com o universo literário da Livraria Class.\n" +
                        "Acesso exclusivo à nossa comunidade de leitores: Participe de grupos de discussão, receba dicas personalizadas e fique por dentro das novidades do mundo dos livros.\n" +
                        "Mas as vantagens não param por aí!\n" +
                        "\n" +
                        "Frete grátis em compras acima de R$ 50: Aproveite para renovar sua estante sem se preocupar com o frete.\n" +
                        "Promoções exclusivas para membros do clube de leitura: Receba ofertas imperdíveis e garanta seus livros favoritos por preços incríveis.\n" +
                        "Eventos literários imperdíveis: Participe de lançamentos, bate-papos com autores e workshops para aprimorar sua experiência com a leitura.\n" +
                        "A equipe da Livraria Class está à disposição para te auxiliar em qualquer dúvida e te ajudar a encontrar o livro perfeito para você.\n" +
                        "\n" +
                        "Acesse nosso site e explore o universo literário que te espera: https://www.livrariacultura.com.br/\n" +
                        "\n" +
                        "Atenciosamente,\n" +
                        "\n" +
                        "Livraria Class\n" +
                        "\n");
        return clienteDTO;
    }

    public void deletarCliente(Long id) {
        clientesRepository.deleteById(id);
    }


    public List<Clientes> listarClientes() {
        List<Clientes> Cls = clientesRepository.findAll();
        return Cls;
    }


}