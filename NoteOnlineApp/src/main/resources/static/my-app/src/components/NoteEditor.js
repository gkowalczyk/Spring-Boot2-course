import React, {useState} from "react";
import styled from "styled-components";

const EditorContainer = styled.div`
  margin-top: 20px;
  padding: 20px;
  border: 1px solid #ddd;
  background: #f9f9f9;
`;

const Input = styled.input`
  width: 100%;
  padding: 10px;
  margin-bottom: 10px;
`;

const Button = styled.button`
  padding: 10px;
  background: blue;
  color: white;
  border: none;
  cursor: pointer;
`;
const NoteEditor = ({note, onUpdate}) => {

    const [title, setTitle] = useState(note.title);
    const [content, setContent] = useState(note.content);

    const handleUpdate = (e) => {
        onUpdate({...note, title, content});
    };

    return (
        <EditorContainer>
            <h3>Edytuj Notatkę</h3>
            <Input value={title} onChange={(e) => setTitle(e.target.value)}/>
            <Input value={content} onChange={(e) => setContent(e.target.value)}/>
            <Button onClick={handleUpdate}>Zapisz zmiany</Button>
        </EditorContainer>
    );
};
export default NoteEditor;
