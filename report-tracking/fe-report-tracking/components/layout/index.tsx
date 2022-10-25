import React, { } from "react"
import Header from "./header"

interface LayoutProps {
    children: JSX.Element
}

const Layout = (props: LayoutProps) => (
    <>
        <Header/>
        <main>{props.children}</main>
    </>
)

export default Layout