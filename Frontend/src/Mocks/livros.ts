interface Livro {
  id: number;
  titulo: string;
  idAutor: number;
  nomeAutor: string;
  preco: number;
  destaque: boolean;
  sumario: string;
  idCategorias: number;
  nomeCategoria: string;
  idEditora: number;
  nomeEditora: string;
  estoque: number;
  imagem: string;
}

export default [
  {
    id: 1,
    titulo: "O Senhor dos Anéis: A Sociedade do Anel",
    idAutor: 101,
    nomeAutor: "J.R.R. Tolkien",
    preco: 59.99,
    destaque: true,
    sumario:
      "Primeiro volume da épica trilogia de J.R.R. Tolkien, onde a jornada de Frodo começa.",
    idCategorias: 201,
    nomeCategoria: "Fantasia",
    idEditora: 301,
    nomeEditora: "HarperCollins",
    estoque: 50,
    imagem: "https://example.com/imagens/senhor-dos-aneis.jpg",
  },
  {
    id: 2,
    titulo: "1984",
    idAutor: 102,
    nomeAutor: "George Orwell",
    preco: 39.9,
    destaque: false,
    sumario: "Um clássico sobre um futuro distópico e a vigilância do governo.",
    idCategorias: 202,
    nomeCategoria: "Ficção Científica",
    idEditora: 302,
    nomeEditora: "Companhia das Letras",
    estoque: 30,
    imagem: "https://example.com/imagens/1984.jpg",
  },
] as Livro[];
