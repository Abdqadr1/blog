import { Navbar, Container, Nav } from "react-bootstrap";
import logo from "../images/logo.png";
import twitter from "../images/twiter.png";
import github from "../images/github.png";
import figma from "../images/figma.png";
import dribble from '../images/dribbble.png';
const NavBar = () => {
    return ( 
        <Navbar bg="white" expand="sm">
            <Container>
                <Navbar.Brand href="#home">
                    <img
                        alt=""
                        src={logo}
                        width="30"
                        height="30"
                        className="d-inline-block align-top"
                        />{' '} Blog
                </Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="ms-auto">
                    <Nav.Link href="#home">
                        <img
                            alt=""
                            src={twitter}
                            width="18"
                            height="18"
                            className="d-inline-block align-top"
                            />
                        </Nav.Link>
                    <Nav.Link href="#home">
                        <img
                            alt=""
                            src={dribble}
                            width="18"
                            height="18"
                            className="d-inline-block align-top"
                            />
                    </Nav.Link>
                    <Nav.Link href="#home">
                        <img
                            alt=""
                            src={figma}
                            width="18"
                            height="18"
                            className="d-inline-block align-top"
                            />
                        </Nav.Link>
                    <Nav.Link href="#home">
                        <img
                            alt=""
                            src={github}
                            width="18"
                            height="18"
                            className="d-inline-block align-top"
                            />
                    </Nav.Link>
                </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
     );
}
 
export default NavBar