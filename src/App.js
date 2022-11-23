import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Rotas from "./rotas/Rotas";
import Dashboard from "./pages/Dashboard";
import ListaEntregador from "./pages/entregador/Lista";

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <>
            <Route element={<Rotas />}>
              <Route path="/" element={<Dashboard />} />
              <Route path="/entregador/lista" element={<ListaEntregador />} />
            </Route>
          </>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
