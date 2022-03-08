import {ReactComponent as GithubIcon} from 'assets/img/github.svg'
import './styles.css'

function NavBar(){
    return(
        <header>
            <nav className="container">
                <div className="dsmovie-nav-content">
                    <h1>DsMovie</h1>
                    <a href="https://github.com/andrezasecon">
                    <div className="dsmovie-contact-container">
                        <GithubIcon/>
                    <p className="dsmovie-contact-link">/andrezasecon</p>
                    </div>
                    </a>
                </div>
            </nav>    
        </header>
  );
}

export default NavBar;