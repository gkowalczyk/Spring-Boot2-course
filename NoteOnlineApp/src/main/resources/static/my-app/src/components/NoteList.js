import React from "react";
import styled from "styled-components";

const ListContainer = styled.div`
    margin: 20px 0;
`;

const NoteItem = styled.div`
  padding: 10px;
  border-bottom: 1px solid #ddd;
  display: flex;
  justify-content: space-between;
  align-items: center;
  cursor: pointer;
  background: #f9f9f9;
  &:hover {
    background: #e9e9e9;
  }
`;

const Button = styled.button`
background: red;
color: white;
border: none'
padding: 5px;
cursor: pointer;
`;

const NoteList = ({notes, onEdit, onDelete}) => {
    return (
        <ListContainer>
            {notes.map((note) => (
                <NoteItem key={note.id} onClick={() => onEdit(note)}>
                    <span>{note.content}</span>
                    <Button onClick={(e) => {
                        e.stopPropagation();
                        onDelete(note.id);
                    }}>Usuń</Button>

                </NoteItem>
            ))}
        </ListContainer>
    );
};

export default NoteList;