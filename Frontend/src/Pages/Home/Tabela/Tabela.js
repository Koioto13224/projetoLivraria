import React, { useState } from 'react';
import Cabecalho from "Enums/Cabecalho"; // Certifique-se de que isso está correto
import NavBar from "Pages/Navbar/Navbar"; // Verifique o caminho da importação
import './Tabela.css';

export default function Tabela() {
    // Exemplo de dados para a tabela (substitua com os dados reais que você tiver)
    const [dados, setDados] = useState([
        { id: 1, descricao: 'Produto 1', categoria: 'Categoria 1', autor: 'Autor 1', preco: 2000000 },
        { id: 2, descricao: 'Produto 2', categoria: 'Categoria 2', autor: 'Autor 2', preco: 1000000 },
        { id: 3, descricao: 'Produto 3', categoria: 'Categoria 3', autor: 'Autor 3', preco: 1500000 },
        // Outros dados aqui...
    ]);

    return (
        <div className="tabela">
        {/* NavBar fixado no topo */}
        <NavBar /> 

        {/* Tabela centralizada */}
        <table>
            <thead>
                <tr>
                    <th>{Cabecalho.ID}</th>
                    <th>{Cabecalho.DESCRICAO}</th>
                    <th>{Cabecalho.CATEGORIA}</th>
                    <th>{Cabecalho.AUTOR}</th>
                    <th>{Cabecalho.PRECO}</th>
                    <th>{Cabecalho.EDITAR}</th>
                </tr>
            </thead>
            <tbody>
                {dados.map((item) => (
                    <tr key={item.id}>
                        <td>{item.id}</td>
                        <td>{item.descricao}</td>
                        <td>{item.categoria}</td>
                        <td>{item.autor}</td>
                        <td>{item.preco}</td>
                        <td><button>Editar</button></td>
                    </tr>
                ))}
            </tbody>
        </table>
    </div>
    );
}
