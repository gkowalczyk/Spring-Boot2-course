import React, {useState} from "react";
import {getCarsNewsFromDb, updateNews} from "../services/CarService";


function CarApiNews() {

    const [news, setNews] = useState([]);
    const [editedNews, setEditedNews] = useState({id: null, description: ""});
    const [confirmation, setConfirmation] = useState(null);

    const fetchCarNews = () => {
        getCarsNewsFromDb()
            .then(response => {
                console.log("API Response:", response.data);
                setNews(response.data);
            })
            .catch(error => console.error("Error fetching news:", error));
    };



    const handleUpdate = () => {
        updateNews(editedNews.id, editedNews.description)
            .then(() => {
                setNews((prevNews) =>
                    prevNews.map((item) =>
                        item.id === Number(editedNews.id) ? { ...item, description: editedNews.description } : item
                    )
                );
                setConfirmation(`News ID ${editedNews.id} has been updated!`);
                setEditedNews({ id: "", description: "" });
            })
            .catch((error) => console.error("Error updating news:", error));
    };


    return (

        <div>
            <h1>Car News API</h1>

            <button onClick={fetchCarNews}>Fetch News</button>

            <div style={{ marginBottom: "20px" }}>
                <h2>Edit News</h2>
                <label>
                    ID News:
                    <input
                        type="number"
                        value={editedNews.id}
                        onChange={(e) => setEditedNews({ ...editedNews, id: e.target.value })}
                        placeholder="Enter ID"
                    />
                </label>
                <br />
                <label>
                    New Description:
                    <input
                        type="text"
                        value={editedNews.description}
                        onChange={(e) => setEditedNews({ ...editedNews, description: e.target.value })}
                        placeholder="Enter a new description"
                    />
                </label>
                <br />
                <button onClick={handleUpdate}>Save</button>
                {confirmation && <p style={{ color: "green" }}>{confirmation}</p>}
            </div>

            <div>
                <ul>
                    {news.map((item) => (
                        <li key={item.news_id}>
                            <strong>ID:</strong> {item.news_id}, <strong>Description:</strong>{" "}
                            {item.description}
                        </li>
                    ))}
                </ul>
            </div>

        </div>
    );
}

export default CarApiNews;
