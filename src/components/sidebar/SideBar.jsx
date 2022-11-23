const SideBar = () => {
  return (
    <nav>
      <div className="sidebar">
        <ul>
          <li className="list">
            <a>
              <i className="fa fa-tachometer" aria-hidden="true"></i>
              <span className="link">Página Principal</span>
            </a>
          </li>
          <li className="list">
            <a>
              <i className="fa fa-address-book-o" aria-hidden="true"></i>
              <span className="link">Entregador</span>
            </a>
          </li>
          <li className="list">
            <a>
              <i className="fa fa-address-book" aria-hidden="true"></i>
              <span className="link">Encomenda</span>
            </a>
          </li>
          <li className="list">
            <a>
              <i className="fa fa-university" aria-hidden="true"></i>
              <span className="link">Cidade</span>
            </a>
          </li>
          <li className="list">
            <a>
              <i className="fa fa-book" aria-hidden="true"></i>
              <span className="link">Produto</span>
            </a>
          </li>
          <li className="list">
            <a>
              <i className="fa fa-pencil-square-o" aria-hidden="true"></i>
              <span className="link">Entrega</span>
            </a>
          </li>
        </ul>
      </div>
    </nav>
  );
};

export default SideBar;
