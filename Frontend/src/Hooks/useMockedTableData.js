import { useState } from "react";

import tabelaMocked from "Mocks/tabelaMocked";

export default function useMockedTableData(){
  const [data, setData] = useState(tabelaMocked)

  return data
}
