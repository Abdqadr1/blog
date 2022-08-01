import { Row, Col, Button } from "react-bootstrap";
import fire from "../images/fire.png";
import Snippet from "./snippet";
const html = `Not long ago I decided to improve the loading times of my website. It already loads pretty fast, but I knew there was still room for improvement and one of them was CSS loading. I will walk you through the process and show you how you can improve your load times as well.<br/>
<br/>To see how CSS affects the load time of a webpage we first have to know how the browser converts an HTML document into a functional webpage...`;
const Home = () => {
    return (
        <>
            <Row className="justify-content-center mx-0 my-3">
                <Col xs="11" md="6" className="bg-ding py-3">
                    <img
                        alt=""
                        src={fire}
                        width="40"
                        height="40"
                        className="d-block mt-3 mb-4"
                    />
                    <h1 className="text-white text-start fw-bold mt-5">Optimizing CSS for faster page loads </h1>
                </Col>
                <Col xs="11" md="6" className="text-start">
                    <Snippet
                        image={null}
                        title="Optimizing CSS for faster page loads"
                        time = {null}
                        content={html}
                     />
                </Col>
            </Row>
            <Row className="justify-content-center mx-0 my-2">
                <Col xs="11" md="4" className="">
                    Read me
                </Col>
                <Col xs="11" md="4">Read more</Col>
                <Col xs="11" md="4">Read more</Col>
            </Row>
            <div className="mt-3 py-3">
                <div className="my-3">Join our Team Of Writers</div>
                <div>
                    <div>On dasdas, writers earn a living doing what they love.</div>
                    <div>Getting started is easy. Just pay a one time $25 fee and everything is ready to go.</div>
                </div>
                <Button variant="dark px-4 mt-4">JOIN US</Button>
            </div>
        </>
    );
}
 
export default Home;