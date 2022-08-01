import { Row, Col, Button, Container } from "react-bootstrap";
import fire from "../images/fire.png";
import { list } from "./blog-list";
import Snippet from "./snippet";
const html = `Not long ago I decided to improve the loading times of my website. It already loads pretty fast, but I knew there was still room for improvement and one of them was CSS loading. I will walk you through the process and show you how you can improve your load times as well.<br/>
<br/>To see how CSS affects the load time of a webpage we first have to know how the browser converts an HTML document into a functional webpage...`;
const Home = () => {
    return (
        <Container fluid="lg" className="pb-5">
            <Row className="justify-content-center mx-0 my-3">
                <Col xs="11" md="6" className="pe-1">
                    <img
                        alt=""
                        src={fire}
                        style={{height: "100%"}}
                        className="d-block w-100"
                    />
                </Col>
                <Col xs="11" md="6" className="text-start px-1">
                    <Snippet
                        image={null}
                        title="Optimizing CSS for faster page loads"
                        time = {null}
                        content={html}
                     />
                </Col>
            </Row>
            <Row className="justify-content-center mx-0 mt-5">
                {
                    list.map(b => <Col key={b.title} xs="11" md="4" className="my-2">
                            <Snippet
                                image={b.image}
                                title={b.title}
                                time = {null}
                                content={b.content}
                            />
                        </Col>
                    )
                }
                {
                    list.map(b => <Col key={b.title} xs="11" md="4" className="my-2">
                            <Snippet
                                image={b.image}
                                title={b.title}
                                time = {null}
                                content={b.content}
                            />
                        </Col>
                    )
                }
            </Row>
            <div className="mt-3 py-3 mb-5">
                <div className="my-3 fw-bold">Join our Team Of Writers</div>
                <div className="text-muted" style={{fontSize: '.9em'}}>
                    <div>On dasdas, writers earn a living doing what they love.</div>
                    <div>Getting started is easy. Just pay a one time <strong>$25 fee</strong> and everything is ready to go.</div>
                </div>
                <Button variant="dark px-5 mt-4 rounded-0">JOIN US</Button>
            </div>
        </Container>
    );
}
 
export default Home;