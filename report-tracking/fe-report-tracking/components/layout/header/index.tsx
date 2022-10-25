import React from "react"
import Image from 'next/image'
import styles from './header.module.scss'

const Header = () => (
    <div className={styles.header}>
        <div className={styles.logo}>
            <div className={styles.image}>
                <Image src="/logo.svg" alt="Momo Logo" width={40} height={40} />
            </div>
            <p className={styles.title}>Developers</p>
        </div>
    </div>
)

export default Header