import React, {useState} from "react";
import styled from "styled-components";

const FormContainer = styled.form`
  display: flex;
  flex-direction: column;
  gap: 10px;
  `;

const Input = styled.input`
padding: 10px;
border: 1px solid #ddd;
`;

const Button = styled.button`
 padding: 10px;
 background: green;
 color: white;
 border: none;
 cursor: pointer;
 
`;

const NoteForm = ({onAddNote}) => {
    const [title, setTitle] = useState("");
    const [content, setContent] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();
        if (!title || !content) return;
        onAddNote({title, content});
        setTitle("");
        setContent("");
    };

    return (
        <FormContainer onSubmit={handleSubmit}>
            <Input value={title} onChange={(e) => setTitle(e.target.value)} placeholder="Tytuł"/>
            <Input value={content} onChange={(e) => setContent(e.target.value)} placeholder="Treść"/>
            <Button type="submit">Dodaj notatkę</Button>
        </FormContainer>
    );
};

export default NoteForm;
