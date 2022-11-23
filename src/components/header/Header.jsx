import React, { useState } from "react";
import * as FaIcons from "react-icons/fa";

const Header = ({ isToogle }) => {
  const [toggled, setToggled] = useState(false);

  const toogleClik = () => {
    setToggled(!toggled);
    isToogle(toggled);
  };

  return (
    <header className="app-header">
      <div className="app-left">
        <div className="app-toggle">
          <i className="fa fa-bars" id="sidebar_toggle"></i>
          <FaIcons.FaBars onClick={() => toogleClik()} />
        </div>

        <div className="app-leftarea">
          <span>TRANSPORTADORA</span>
        </div>
      </div>
      <div className="profile">
        {/* <img th:src="@{/img/perfil.png}" alt="foto"/> */}
        <span>MURILO FERNANDES</span>
        <div className="logout">
          <i className="fa fa-sign-out"></i>
        </div>
      </div>
    </header>
  );
};

export default Header;
