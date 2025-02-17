import React from "react";
import styled from "styled-components";

const HeaderContainer = styled.header`
  text-align: center;
  padding: 20px;
  background: #017bff;
  color: white;
  font-size: 24px;
  font-weight: bold;
  gap: 10px;
  margin-bottom: 20px;
`;

const Header = () => {
    return <HeaderContainer>📒 Notatnik Online</HeaderContainer>;
};

export default Header;
