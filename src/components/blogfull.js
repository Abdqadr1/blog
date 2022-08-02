import { Container, Row, Col } from "react-bootstrap";
import grid from "../images/grid.png";
import { list } from "./blog-list";
import Snippet from "./snippet";
const BlogFull = () => {
    return (
        <> 
            <Container fluid="sm" className="text-start py-5 px-4">
                <div className="text-xsmall">By Ryan Jackson 2 Month Ago </div>
                <h4 className="fw-bold mt-2">Optimizing CSS for faster page loads</h4>
                <p className="mb-5">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                    Nunc non blandit massa enim. Pulvinar sapien et ligula ullamcorper malesuada proin libero nunc consequat.
                    Aliquam sem fringilla ut morbi tincidunt augue interdum velit. Tellus elementum sagittis vitae et leo duis ut diam.
                    Eget nullam non nisi est sit amet. Dignissim suspendisse in est ante in nibh mauris. Nec feugiat in fermentum posuere urna.
                    Diam in arcu cursus euismod quis viverra. Facilisis mauris sit amet massa vitae tortor condimentum lacinia.
                    Diam quam nulla porttitor massa id neque aliquam vestibulum morbi.
                    Sed egestas egestas fringilla phasellus faucibus scelerisque eleifend. Sed elementum tempus egestas sed sed risus pretium quam vulputate.
                    Lacus sed turpis tincidunt id aliquet risus feugiat in ante.Viverra nibh cras pulvinar mattis nunc sed blandit libero.
                    Morbi tincidunt augue interdum velit euismod in. Accumsan lacus vel facilisis volutpat est velit egestas dui.
                    Erat pellentesque adipiscing commodo elit at imperdiet. Quis risus sed vulputate odio ut.
                    Nulla aliquet enim tortor at auctor urna.
                </p>
                <div className="px-5">
                    <img
                        alt="grid"
                        src={grid}
                        height="400"
                        className="d-inline-block align-top w-100 mb-4"
                        />
                </div>
                <p className="mt-4">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nunc non blandit massa enim. Pulvinar sapien et ligula ullamcorper malesuada proin libero nunc consequat. Aliquam sem fringilla ut morbi tincidunt augue interdum velit. Tellus elementum sagittis vitae et leo duis ut diam. Eget nullam non nisi est sit amet. Dignissim suspendisse in est ante in nibh mauris. Nec feugiat in fermentum posuere urna. Diam in arcu cursus euismod quis viverra. Facilisis mauris sit amet massa vitae tortor condimentum lacinia. Diam quam nulla porttitor massa id neque aliquam vestibulum morbi. Sed egestas egestas fringilla phasellus faucibus scelerisque eleifend. Sed elementum tempus egestas sed sed risus pretium quam vulputate. Lacus sed turpis tincidunt id aliquet risus feugiat in ante. Viverra nibh cras pulvinar mattis nunc sed blandit libero. Morbi tincidunt augue interdum velit euismod in. Accumsan lacus vel facilisis volutpat est velit egestas dui. Erat pellentesque adipiscing commodo elit at imperdiet. Quis risus sed vulputate odio ut. Nulla aliquet enim tortor at auctor urna.

Proin fermentum leo vel orci porta non pulvinar neque. In egestas erat imperdiet sed euismod nisi porta lorem. Metus vulputate eu scelerisque felis imperdiet proin fermentum. Luctus venenatis lectus magna fringilla. Nunc scelerisque viverra mauris in aliquam. Et molestie ac feugiat sed lectus vestibulum mattis. Sem et tortor consequat id porta nibh venenatis cras sed. Sed felis eget velit aliquet sagittis id. Auctor neque vitae tempus quam pellentesque nec nam aliquam sem. Tincidunt ornare massa eget egestas purus viverra accumsan in. Aliquet lectus proin nibh nisl condime.</p>
            </Container>

            <Container fluid="sm" className="px-0">
                <h5 className="fw-bold text-start">More Articles</h5>
                <Row className="justify-content-center mb-5 mt-2">
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
            </Container>
            
        </>
     );
}
 
export default BlogFull;