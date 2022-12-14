import { Page, withModel } from '@adobe/aem-react-editable-components';
import React from 'react';
import Header from './components/Header/Header';
import SubHeader from './components/SubHeader/SubHeader';

// This component is the application entry point
class App extends Page {
  render() {
    return (
      <div>
        <Header />
        <SubHeader />
        {this.childComponents}
        {this.childPages}
      </div>
    );
  }
}

export default withModel(App);
