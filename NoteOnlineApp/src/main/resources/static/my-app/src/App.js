import React, {useState, useEffect} from "react";
import axios from "axios";
import styled from "styled-components";
import NoteList from "./components/NoteList";
import Header from "./components/Header";
import NoteForm from "./components/NoteForm";
import NoteEditor from "./components/NoteEditor";

const Container = styled.div`
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  font-family: Arial, sans-serif;
`;

function App() {
    const [notes, setNotes] = useState([]);
    const [selectedNote, setSelectedNote] = useState(null);

    const fetchNotes = () => {
        axios.get("http://localhost:8080/note")
            .then(response => {
                setNotes(response.data);
            })
            .catch(error => console.error("Błąd ładowania notatek:", error));
    };

    useEffect(() => {
        fetchNotes();
    }, []);

    const deleteNote = (id) => {
        axios.delete(`http://localhost:8080/note/${id}`)
            .then(() => {
                setNotes(prevNotes => prevNotes.filter(note => note.id !== id));
            })
            .catch(error => {
                console.error("Błąd usuwania notatki:", error);
            });
    };

    const addNote = (note) => {
        axios.post("http://localhost:8080/note", note)
            .then(response => {
                setNotes(prevNotes => [...prevNotes, response.data]);
                fetchNotes();
            })
            .catch(error => {
                console.error("Błąd dodawania notatki:", error);
            });
    }

    const updateNote = (note) => {
        axios.put(`http://localhost:8080/note`, note)
            .then(() => {
                setNotes(prevNotes => prevNotes.map(n => n.id === note.id ? note : n));
                fetchNotes();
                setSelectedNote(null);
            })
    };

    return (
        <Container>
            <Header/>
            <NoteForm onAddNote={addNote}/>
            <NoteList notes={notes} onEdit={setSelectedNote} onDelete={deleteNote}/>
            {selectedNote && <NoteEditor note={selectedNote} onUpdate={updateNote}/>}
        </Container>
    );
}

export default App;
