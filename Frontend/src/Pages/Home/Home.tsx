import livros from "@/Mocks/livros";

export default function Home() {
  return (
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Título</th>
          <th>ID Autor</th>
          <th>Nome do Autor</th>
          <th>Preço (R$)</th>
          <th>Destaque</th>
          <th>Sumário</th>
          <th>ID Categoria</th>
          <th>Nome da Categoria</th>
          <th>ID Editora</th>
          <th>Nome da Editora</th>
          <th>Estoque</th>
          <th>Imagem</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td>O Senhor dos Anéis: A Sociedade do Anel</td>
          <td>101</td>
          <td>J.R.R. Tolkien</td>
          <td>59.99</td>
          <td>Sim</td>
          <td>
            Primeiro volume da épica trilogia de J.R.R. Tolkien, onde a jornada
            de Frodo começa.
          </td>
          <td>201</td>
          <td>Fantasia</td>
          <td>301</td>
          <td>HarperCollins</td>
          <td>50</td>
          <td>
            <img
              src="https://example.com/imagens/senhor-dos-aneis.jpg"
              alt="O Senhor dos Anéis"
              width="50"
            />
          </td>
        </tr>
        <tr>
          <td>2</td>
          <td>1984</td>
          <td>102</td>
          <td>George Orwell</td>
          <td>39.90</td>
          <td>Não</td>
          <td>
            Um clássico sobre um futuro distópico e a vigilância do governo.
          </td>
          <td>202</td>
          <td>Ficção Científica</td>
          <td>302</td>
          <td>Companhia das Letras</td>
          <td>30</td>
          <td>
            <img
              src="https://example.com/imagens/1984.jpg"
              alt="1984"
              width="50"
            />
          </td>
        </tr>
        <tr>
          <td>3</td>
          <td>Dom Quixote</td>
          <td>103</td>
          <td>Miguel de Cervantes</td>
          <td>49.50</td>
          <td>Não</td>
          <td>A história do cavaleiro que luta contra moinhos de vento.</td>
          <td>203</td>
          <td>Literatura Clássica</td>
          <td>303</td>
          <td>Editora Abril</td>
          <td>20</td>
          <td>
            <img
              src="https://example.com/imagens/dom-quixote.jpg"
              alt="Dom Quixote"
              width="50"
            />
          </td>
        </tr>
        <tr>
          <td>4</td>
          <td>Harry Potter e a Pedra Filosofal</td>
          <td>104</td>
          <td>J.K. Rowling</td>
          <td>45.00</td>
          <td>Sim</td>
          <td>O começo da jornada do jovem bruxo Harry Potter.</td>
          <td>201</td>
          <td>Fantasia</td>
          <td>304</td>
          <td>Rocco</td>
          <td>100</td>
          <td>
            <img
              src="https://example.com/imagens/harry-potter.jpg"
              alt="Harry Potter"
              width="50"
            />
          </td>
        </tr>
      </tbody>
    </table>
  );
}
