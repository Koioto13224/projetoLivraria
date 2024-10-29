import './meio.css';
import { useState } from 'react';
import http from '../axios';

function Meio() {
  const [id, setId] = useState('');
  const [nome, setNome] = useState('');
  const [ativo, setAtivo] = useState(null); // Inicia com null para indicar que não foi selecionado
  const [mensagem, setMensagem] = useState('');
  const [loading, setLoading] = useState(false);

  async function montaJson() {
    if (!id || !nome || ativo === null) { // Verifica se o ativo foi definido
      setMensagem('Por favor, preencha todos os campos e selecione o status Ativo ou Inativo.');
      return;
    }

    const json = {
      id: id,
      nome: nome,
      ativo: ativo,
    };

    await enviaDados(json);
  }

  function enviaDados(json) {
    setLoading(true);
    return http.post('http://localhost:9091/criarCategorias', json)
      .then(resp => {
        setId('');
        setNome('');
        setAtivo(null); // Reseta o estado após o envio
        setMensagem("Dados salvos com sucesso");
        setTimeout(() => setMensagem(''), 3000); // Limpa a mensagem após 3 segundos
        return resp.data;
      })
      .catch(erro => {
        setMensagem("Erro ao salvar os dados");
        console.error("Erro ao salvar os dados:", erro);
      })
      .finally(() => {
        setLoading(false);
      });
  }

  return (
    <div className="meio">
      <div className='noticia'>
        {mensagem && <div className='mensagem'>{mensagem}</div>}
        <div className='div'>
          <p>ID</p>
          <input 
            type="text" 
            onChange={e => setId(e.target.value)} 
            value={id} 
            placeholder='Digite o ID' 
          />
          <p>Nome</p>
          <input 
            type="text" 
            onChange={e => setNome(e.target.value)} 
            value={nome} 
            placeholder='Digite o Nome Completo' 
          />
          <p>Ativo</p>
          <div>
            <button 
              onClick={() => setAtivo(true)} 
              className={ativo === true ? 'active' : ''}
            >
              Ativo
            </button>
            <button 
              onClick={() => setAtivo(false)} 
              className={ativo === false ? 'active' : ''}
            >
              Inativo
            </button>
          </div>
          <button onClick={montaJson} disabled={loading}>
            {loading ? 'Salvando...' : 'Salvar'}
          </button>
        </div>
      </div>
    </div>
  );
}

export default Meio;

