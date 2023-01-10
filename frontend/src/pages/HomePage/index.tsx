import { ContainerDefault } from '../../components/common/ContainerDefault';
import { ContentDefault } from '../../components/common/ContentDefault';
import { HeadingDefault } from '../../components/common/HeadingDefault';

const HomePage: React.FC = () => {
  return (
    <ContainerDefault>
      <ContentDefault>
        <HeadingDefault>Home</HeadingDefault>
      </ContentDefault>
    </ContainerDefault>
  );
};

export default HomePage;
