const Snippet = ({image, title, time, content}) => {
    return ( 
        <div className="p-2" style={{ width: '100%' }}>
            {
                (image) && <img
                    alt={title}
                    src={image}
                    height="300"
                    className="d-inline-block align-top w-100 mb-2"
                />
            }
            <div className="text-xsmall">Front end - 1 Hour Ago</div>
            <h6 className="fw-bold mt-2">{title}</h6>
            <p className="text-small" dangerouslySetInnerHTML={{__html: content}}></p>
            <div className="d-flex flex-wrap justify-content-between align-items-center fs-6">
                <span className="text-small">3 min Read</span>
                <a href="/">
                    <span className="text-small">Read Full </span>
                    <span className="material-icons-outlined text-small">arrow_right_alt</span>
                </a>
            </div>
        </div>
    );
}
 
export default Snippet;