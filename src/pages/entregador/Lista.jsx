import { useEffect } from "react";
import { useState } from "react";
import { Link } from "react-router-dom";
import { listarEntregador } from "../../services/entregadorService";

export default function ListaEntregador() {
  const [entregadores, setEntregadores] = useState([]);

  useEffect(() => {
    getDataEntregador();
  }, []);

  const getDataEntregador = async () => {
    const response = await listarEntregador();
    setEntregadores(response);
  };

  return (
    <div className="app-content">
      <div className="app-titulo">
        <div>
          {/* <h1>
            Título <FaIcons.faListAlt />
            Lista de Entregadores
          </h1> */}
        </div>
        <ul className="app-breadcrumb breadcrumb">
          <li className="breadcrumb-item">
            <i className="fa fa-home" aria-hidden="true"></i>
          </li>
          <li className="breadcrumb-item">
            <Link to={"/home"}>
              <a>Dashboard</a>
            </Link>
          </li>
        </ul>
      </div>
      <div className="row">
        <div className="col-md-12">
          <div className="listagem">
            <div className="row justify-content-center">
              <form className="">
                <div className="row mb-3">
                  <label htmlFor="filtro" className="col-sm-1 col-form-label">
                    Filtro:
                  </label>
                  <div className="col-xs-11 col-sm-11 col-md-6 col-log-6">
                    <input
                      type="text"
                      id="filtro"
                      name="keyword"
                      className="form-control"
                    />
                  </div>
                  <div className="col-xs-12 col-sm-12 col-md-4 col-log-4">
                    <button
                      type="submit"
                      className="btn btn-primary form-control"
                    >
                      Pesquisar
                    </button>
                  </div>
                </div>
              </form>
              <div id="no_more_table">
                <table
                  id="tableEntregador"
                  className="table table-striped table-bordered table-hover table-collapse cf"
                >
                  <thead className="cf">
                    <tr className="p-3 mb-2 bg-success text-white">
                      <th>Id</th>
                      <th>Código Entregador</th>
                      <th>Nome</th>
                      <th>Cidade</th>
                      <th>Ações</th>
                    </tr>
                  </thead>
                  <tbody>
                    {entregadores &&
                      entregadores.map((res) => (
                        <tr>
                          <td>{res.idEntregador}</td>
                          <td data-label="Código">{res.codEntregador}</td>
                          <td>{res.nomeEntregador}</td>
                          <td>{res.cidade.nomeCidade}</td>
                          <td data-label="Ação" className="text-center">
                            <a
                              type="button"
                              className="btn btn-info btn-sm"
                              title="Alterar dados do entregador selecionado"
                            >
                              <i className="fa fa-pencil"></i>
                            </a>
                            <a
                              type="button"
                              className="btn btn-danger btn-sm"
                              title="Excluir dados do entregador selecionado"
                            >
                              <i className="fa fa-trash"></i>
                            </a>
                            <a
                              className="btn btn-success btn-sm"
                              type="button"
                              title="Consultar dados do entregador selecionado"
                            >
                              <i className="fa fa-search-plus"></i>
                            </a>
                          </td>
                        </tr>
                      ))}
                  </tbody>
                </table>
              </div>
              <nav aria-label="Page navigation example">
                <ul className="pagination justify-content-end">
                  <li className="page-item disabled">
                    <a
                      className="page-link"
                      href="#"
                      tabindex="-1"
                      aria-disabled="true"
                    >
                      Previous
                    </a>
                  </li>
                  <li className="page-item">
                    <a className="page-link" href="#">
                      1
                    </a>
                  </li>
                  <li className="page-item">
                    <a className="page-link" href="#">
                      2
                    </a>
                  </li>
                  <li className="page-item">
                    <a className="page-link" href="#">
                      3
                    </a>
                  </li>
                  <li className="page-item">
                    <a className="page-link" href="#">
                      Next
                    </a>
                  </li>
                </ul>
              </nav>
            </div>
            <div>
              <a type="button" className="btn btn-primary btn-lg">
                Novo Entregador
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
