import { Outlet } from "react-router-dom";
import Cabecalho from "../cabecalho/cabecalho";
import Rodape from "../rodape/rodape";

const PaginaPadrao = () => {
    return (
        <>
            <Cabecalho />
            <div>
                <Outlet />
            </div>
            <Rodape />
        </>
    )
}

export default PaginaPadrao;