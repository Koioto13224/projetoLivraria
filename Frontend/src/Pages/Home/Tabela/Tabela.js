import Cabecalho from "Enums/Cabecalho";
import './Tabela.css';
export default function Tabela(){
    return(
        <div className="tabela">
        <table >
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
            <tr>
                <td>1</td>
                <td>teste</td>
                <td>teste</td>
                <td>teste</td>
                <td>2000000</td>
                <td></td>
            </tr>
        </tbody>
    </table>
    </div>
    )
}