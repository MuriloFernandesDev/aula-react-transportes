import React, { Fragment } from "react";
import styled from "styled-components";

const Content = (props) => {
  return (
    <Fragment>
      <ContentContainer sideBar={props.sideBar}>
        {props.children}
      </ContentContainer>
    </Fragment>
  );
};

export default Content;

const ContentContainer = styled.div`
  min-height: calc(100vh - 70px);
  padding: 30px;
  background-color: #e5e5e5;

  margin-left: ${({ sideBar }) => (sideBar ? "220px" : "78px")};
`;

export const WindowTitle = styled.div`
  display: -weblit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: center;
  -ms-flex-align: center;
  -webkit-box-pack: justify;
  -ms-flex-packi: justify;
  justify-content: space-between;
  -webkit-box-orient: horizontal;
  -webkit-box-direction: normal;
  -ms-flex-direction: row;
  flex-direction: row;
  background-color: #fff;
  margin: -30px -30px 30px;
  padding: 20px 30px;
  -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, 0.1);
  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.1);
`;

export const Window = styled.div`
  position: relative;
  background: #ffffff;
  border-radius: 3px;
  padding: 20px;
`;

export const WindowFooter = styled.div`
  border-top: 1px solid #ddd;
  padding: 20px 0 0 0;
  margin-top: 10px;
  background-color: #fff;
`;
