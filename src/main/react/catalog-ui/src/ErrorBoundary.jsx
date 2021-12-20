import React from 'react'

export default class ErrorBoundary extends React.Component {


    constructor(props, context) {
        super(props, context);
        this.state = {
            error: null
        }
    }

    componentDidCatch(error, errorInfo) {
        this.setState({error: error})
    }

    render() {
        if (this.state.error) {
            return (
                <div style={{backgroundColor: 'red', color: 'black'}}>
                    <h2>An error occurred</h2>
                </div>
            )
        } else {
            return this.props.children
        }
    }
}