import './cabecalho.css';
import { Link } from 'react-router-dom';

function Cabecalho() {
  return (
    <>
      <header className='cabecalho'>
        <div className='estilo'>
          <Link to='/' className='botao-titulo'>StarBook</Link>
        </div>
        <div>
          <ul>
            <li>
              <Link to={'/'}>Página inicial</Link>
            </li>
            <li>
              <Link to={'/novaTela'}>Nova Tela</Link>
            </li>
            <li>
              <Link to={'/login'}>Login</Link>
            </li>
          </ul>
        </div>
      </header>
    </>
  );
}

export default Cabecalho;

