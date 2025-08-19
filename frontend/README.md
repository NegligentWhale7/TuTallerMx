# TuTallerMx Frontend Documentation

## Overview
The frontend of TuTallerMx is a web application built with React and Vite. It provides a user interface for browsing vehicles, viewing articles, and interacting with automotive data. The project is organized for scalability and maintainability, using modular components and a clear folder structure.

## Project Structure
```
frontend/
├── public/           # Static assets (images, logo, etc.)
├── src/              # Source code
│   ├── components/   # React components (article, vehicle)
│   ├── data/         # Data files (data.js)
│   ├── App.jsx       # Main App component
│   ├── index.css     # Global styles
│   └── main.jsx      # Entry point
├── index.html        # HTML template
├── package.json      # Project dependencies and scripts
├── vite.config.js    # Vite configuration
└── README.md         # Project documentation
```

## Key Features
- **Vehicle Gallery:** Displays a list of vehicles with images and details.
- **Articles:** Shows automotive articles and information.
- **Responsive Design:** Optimized for desktop and mobile devices.
- **Fast Development:** Uses Vite for fast builds and hot module replacement.

## Main Components
- `App.jsx`: Root component that manages routing and layout.
- `components/article.jsx`: Renders articles about vehicles or automotive topics.
- `components/vehicle.jsx`: Displays individual vehicle details.
- `data/data.js`: Contains vehicle and article data used throughout the app.

## Static Assets
All images and static files are stored in `public/`. Vehicle images are in `public/images/` and are referenced in the data files.

## Getting Started
1. **Install dependencies:**
	```powershell
	cd frontend
	npm install
	```
2. **Run the development server:**
	```powershell
	npm run dev
	```
3. **Open the app:**
	Visit `http://localhost:5173` in your browser.

## Build for Production
To build the frontend for production:
```powershell
npm run build
```
The output will be in the `dist/` folder.

## Linting
ESLint is configured for code quality. To run lint checks:
```powershell
npm run lint
```

## Customization
- Add new components in `src/components/` as needed.
- Update styles in `src/index.css`.

## Contributing
Feel free to submit issues or pull requests for improvements or new features.

## License
This project is licensed under the MIT License.

