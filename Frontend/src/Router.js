import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';
import PaginaPadrao from './PaginaPadrao/paginaPadrao';
import Meio from './meio/meio';
import NovaTela from './NovaTela/NovaTela.js';
const AppRouter = () => {
    return (
        <main>
            <Router>
                <Routes>
                    <Route path='/' element={<PaginaPadrao />}>
                        <Route index element={<Meio />} />
                        <Route path='/novaTela' element={<NovaTela />}></Route>
                        {/* <Route path='/create-user/new' element={<CreateUser />}></Route>
                        <Route path='/batalha/new' element={  <NewPlay /> }></Route> */}
                    </Route>
                </Routes>
            </Router>
        </main>
    )
}

export default AppRouter;