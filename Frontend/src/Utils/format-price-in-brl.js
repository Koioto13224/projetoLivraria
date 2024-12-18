export default function formatPriceInBRL(num) {
  const formatter = new Intl.NumberFormat('pt-br', {
    style: "currency",
    currency: "BRL"
  })

  return formatter.format(Number(num))
}
