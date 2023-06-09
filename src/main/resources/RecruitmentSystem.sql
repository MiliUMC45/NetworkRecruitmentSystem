USE [master]
GO
/****** Object:  Database [RecruitmentSystem]    Script Date: 2023/5/15 22:47:07 ******/
CREATE DATABASE [RecruitmentSystem]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'RecruitmentSystem', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\RecruitmentSystem.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'RecruitmentSystem_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\RecruitmentSystem_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [RecruitmentSystem] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [RecruitmentSystem].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [RecruitmentSystem] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [RecruitmentSystem] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [RecruitmentSystem] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [RecruitmentSystem] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [RecruitmentSystem] SET ARITHABORT OFF 
GO
ALTER DATABASE [RecruitmentSystem] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [RecruitmentSystem] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [RecruitmentSystem] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [RecruitmentSystem] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [RecruitmentSystem] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [RecruitmentSystem] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [RecruitmentSystem] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [RecruitmentSystem] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [RecruitmentSystem] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [RecruitmentSystem] SET  DISABLE_BROKER 
GO
ALTER DATABASE [RecruitmentSystem] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [RecruitmentSystem] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [RecruitmentSystem] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [RecruitmentSystem] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [RecruitmentSystem] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [RecruitmentSystem] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [RecruitmentSystem] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [RecruitmentSystem] SET RECOVERY FULL 
GO
ALTER DATABASE [RecruitmentSystem] SET  MULTI_USER 
GO
ALTER DATABASE [RecruitmentSystem] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [RecruitmentSystem] SET DB_CHAINING OFF 
GO
ALTER DATABASE [RecruitmentSystem] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [RecruitmentSystem] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [RecruitmentSystem] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [RecruitmentSystem] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'RecruitmentSystem', N'ON'
GO
ALTER DATABASE [RecruitmentSystem] SET QUERY_STORE = OFF
GO
USE [RecruitmentSystem]
GO
/****** Object:  Table [dbo].[company]    Script Date: 2023/5/15 22:47:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[company](
	[company_id] [int] IDENTITY(1,1) NOT NULL,
	[company_name] [nvarchar](30) NOT NULL,
	[kind] [nvarchar](10) NOT NULL,
	[introduction] [nvarchar](500) NULL,
	[icon] [nvarchar](50) NULL,
 CONSTRAINT [PK_company] PRIMARY KEY CLUSTERED 
(
	[company_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[job]    Script Date: 2023/5/15 22:47:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[job](
	[job_id] [int] IDENTITY(1,1) NOT NULL,
	[job_name] [nchar](20) NOT NULL,
	[pay] [nchar](20) NOT NULL,
	[company_id] [int] NOT NULL,
	[introduction] [nvarchar](500) NULL,
 CONSTRAINT [PK_job] PRIMARY KEY CLUSTERED 
(
	[job_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[personnels]    Script Date: 2023/5/15 22:47:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[personnels](
	[personnel_id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nchar](20) NOT NULL,
	[company_id] [int] NOT NULL,
	[password] [nchar](20) NOT NULL,
	[telephone] [nchar](11) NULL,
	[email] [nchar](30) NULL,
	[sex] [nchar](1) NULL,
 CONSTRAINT [PK_personnels] PRIMARY KEY CLUSTERED 
(
	[personnel_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 2023/5/15 22:47:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[user_id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nchar](20) NOT NULL,
	[password] [nchar](20) NOT NULL,
	[sex] [nchar](1) NULL,
	[email] [nchar](30) NULL,
	[telephone] [nchar](11) NULL,
 CONSTRAINT [PK_users] PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[company] ON 

INSERT [dbo].[company] ([company_id], [company_name], [kind], [introduction], [icon]) VALUES (1, N'七星娱乐', N'娱乐经纪', N'七星娱乐成立于2005年，是一家集明星代言、演出活动、央视广告、影视制作、品牌策划为一体的大型综合性传媒机构。旗下拥有两家实力传媒公司北京七星娱乐广告有限公司，北京七星影视文化传播有限公司。公司自成立至今，在全国的合作客户达到千例以上，是中央电视台金牌代理公司，是明星代言行业的领跑者！我们拥有强大的明星资源、资深的央视广告发布经验、专业的制作团队，七星娱乐已成为国内传媒行业最具竞争力的传媒品牌。诚信、高效的服务理念，使公司的合作客户一直保持高速增长，更使客户达到了百分百的高满意度。', N'image/company_icon/default_icon.png')
INSERT [dbo].[company] ([company_id], [company_name], [kind], [introduction], [icon]) VALUES (2, N'米哈游', N'互联网/游戏', N'米哈游成立于2011年，致力于为用户提供美好的、超出预期的产品与内容。米哈游陆续推出了多款高品质人气产品，包括《崩坏学园2》、《崩坏3》、《未定事件簿》、《原神》、《崩坏：星穹铁道》，动态桌面软件《人工桌面》以及社区产品《米游社》，并围绕原创IP打造了动画、音乐及周边等多元产品。即将上线的《绝区零》等同样受到全球玩家广泛关注。', N'image/company_icon/mihoyo.jpg')
INSERT [dbo].[company] ([company_id], [company_name], [kind], [introduction], [icon]) VALUES (3, N'华为', N'互联网', N'华为创立于1987年，是全球领先的ICT（信息与通信）基础设施和智能终端提供商。我们的20.7万员工遍及170多个国家和地区，为全球30多亿人口提供服务。我们致力于把数字世界带入每个人、每个家庭、每个组织，构建万物互联的智能世界。', N'image/company_icon/huawei.jpg')
INSERT [dbo].[company] ([company_id], [company_name], [kind], [introduction], [icon]) VALUES (4, N'太平洋房屋', N'房地产', N'太屋集团始创于上海，是一个以“服务于人类居住”为核心的集团化企业。集团立足于房地
产服务行业，历经27年发展，企业从房地产经纪、房地产咨询代理、商业招商等业务模块
开始起步，逐步发展出资产管理3、供应链金融、地产开发、互联网科技、职业教育等全3新业
务模块，伴随着20多家子公司和5个子品牌的相继成立，企业开始走向集团化发展的道路。
太屋集团一直以来秉承“锐意进取，开拓创新”的发展理念，以品质服务赢得社会各界的广泛认可和客户的高度信赖。', N'image/company_icon/pacific_rehouse.jpg')
INSERT [dbo].[company] ([company_id], [company_name], [kind], [introduction], [icon]) VALUES (5, N'行动教育', N'咨询', N'行动教育--实效商学院，中国企业管理教育第一股（股票代码：605098），为企业提供全生命周期服务，包含实效管理培训、咨询辅导、年度顾问和学习工具。
拥有470余项商标、著作权等知识产权，在全国设有分/子公司及其它分支机构，已服务15万+企业家学员，如顾家家居、  西贝、名创优品、味千拉面、海澜之家、合力泰等。
多年以来，行动教育一直以实效落地显著、贴近企业而著称。', N'image/company_icon/action_edu.jpg')
INSERT [dbo].[company] ([company_id], [company_name], [kind], [introduction], [icon]) VALUES (6, N'星巴克咖啡', N'生活服务', N'星巴克咖啡公司成立于1971年，始终致力于商业道德采购并烘焙世界上高品质的阿拉比卡咖啡。今天，在全球76个国家和地区，拥有28,000多家门店的星巴克是世界上首屈一指的专业咖啡烘焙商和零售商。

自1999年进入中国以来，秉承“激发并孕育人文精神——每人、每杯、每个社区”的公司使命，我们始终致力于在中国成为一家与众不同的公司：在传承经典咖啡文化的同时，关爱我们的伙伴，为顾客提供超越期望的星巴克体验，并为所在社区的繁荣做出自己的贡献。目前星巴克已经在中国大陆130多个城市开设了3,000多家门店，拥有40,000多名身穿绿围裙的星巴克伙伴。这一独特优势使我们能够在每一天，通过每一家星巴克门店，践行我们的承诺。', N'image/company_icon/starbucks.jpg')
SET IDENTITY_INSERT [dbo].[company] OFF
GO
SET IDENTITY_INSERT [dbo].[job] ON 

INSERT [dbo].[job] ([job_id], [job_name], [pay], [company_id], [introduction]) VALUES (1, N'抖音直播场控              ', N'4K-8K               ', 1, N'工作内容：
1.开播前设备检查；
2.直播期间后台的操作，搭配主播话术口播；
3.关注品牌群内运营和投手的信息，并及时把信息传达给主播；
4.主播直播期间如临时离开需要短时间上镜替播（5分钟内）；
5、主要直播间以大牌美妆为主，对美妆感兴趣的优先；
要求：
男生/女生均可，年龄不超过30岁,妆容整洁，声音洪亮，性格外向不腼腆，学习能力及适应能力强，住浦东或者地铁沿线，路程一小时之内（欢迎应届毕业生前来挑战），喜欢平凡跳槽体验生活的宝宝勿扰！
薪资待遇：
1、新人带薪15天培训期
2、6个月试用期(表现优异可提前转正）交五险一金
3、一年多次福利')
INSERT [dbo].[job] ([job_id], [job_name], [pay], [company_id], [introduction]) VALUES (2, N'抖音摄影/摄像师            ', N'6K-10K              ', 1, N'抖音摄影/摄像师
岗位职责：
1.熟练掌握索尼、佳能数码单反相机及爱图仕、南光系列灯光；（不接受小白）
2.根据客户需求挑选合适的摄影设备；
3.能熟练安装、搭建、布局摄影设备；
4.根据客户要求熟练调整相应设备；
5.负责直播间的技术支持，对直播环境、灯光、网络质量等进行调试，指定并优化直播间相关技术流程规范；
岗位要求
1.具有娴熟的摄影技巧；
2.掌握影像和构图知识；
3.掌握一定的美学知识，具有一定的艺术修养；
4.了解抖音直播生态及直播画面（美妆护肤）；
5.认真负责，肯吃苦，能在公司长期发展的优先； 排班制（做六休一）
6.沟通能力和执行能力较强，能承受一定的工作压力')
INSERT [dbo].[job] ([job_id], [job_name], [pay], [company_id], [introduction]) VALUES (3, N'设备/抖音直播间灯光师         ', N'6K-10K              ', 1, N'设备/抖音直播间灯光师
岗位职责
 1、负责直播间软硬件平台搭建、优化及运维； 
2、负责直播间的技术支持，对直播环境、灯光、网络质量等进行调试，指定并优化直播间相关技术流程规范； 
3、熟练掌握直播间基本操作流程，完成开播、试音、灯光调试等直播间等基本操作； 
4、判断和解决直播现场的硬件、网络、推流等技术问题、处理直播突发故障，保障直播的顺利进行； 
5、整理总结直播问题，参与优化完善直播保障流程； 任职资格 
1、对直播行业有一定的了解和兴趣； 
2、大专以上学历，电子商务、及计算机等相关专业优先； 
3、熟练掌握sony/canon设备 
4、沟通能力和执行能力较强，能承受一定的工作压力； 
5、有良好的职业道德和素养，诚实、忠诚、尽责、勤奋、认真细心，学习能力强，具有较强的团队合作精神； 
6、稳定，能在公司长期发展的优先； 
排班制（做六休一）')
INSERT [dbo].[job] ([job_id], [job_name], [pay], [company_id], [introduction]) VALUES (4, N'3D特效                ', N'15-30K·16薪          ', 2, N'岗位职责：
1.根据项目的美术风格，制作高品质的游戏特效；
2.主要负责Cutscene特效以及大招特效制作；
3.够配合开发同学一起提升游戏中的特效表现；
4.高效的完成特效的设计及制作，输出设计标准、标杆和规范；
5.跟进最终完成的特效和最终在游戏中的表现。')
INSERT [dbo].[job] ([job_id], [job_name], [pay], [company_id], [introduction]) VALUES (5, N'3D特效-绝区零            ', N'15-30K·16薪          ', 2, N'岗位职责：
1.根据项目的美术风格，制作高品质的游戏特效；
2.主要负责Cutscene特效以及大招特效制作；
3.够配合开发同学一起提升游戏中的特效表现；
4.高效的完成特效的设计及制作，输出设计标准、标杆和规范；
5.跟进最终完成的特效和最终在游戏中的表现。')
INSERT [dbo].[job] ([job_id], [job_name], [pay], [company_id], [introduction]) VALUES (6, N'资深基础安全工程师           ', N'30-60K·16薪          ', 2, N'岗位职责：
1、负责基础安全能力建设，包括但不限于云服务安全、容器安全能力建设，以及主流应用框架的安全防护方案，完善纵深防御体系以及相关安全项目的管理和推进；
2、负责监测软件供应链安全、边界风险，交付安全、运维部署等基础设施安全；
3、负责联合多部门协作，利用安全平台和日志大数据和对安全事件进行识别和快速响应、跟踪和调查；
4、跟进安全行业前沿趋势，持续对公司云服务安全防护体系进行优化。
')
INSERT [dbo].[job] ([job_id], [job_name], [pay], [company_id], [introduction]) VALUES (7, N'Java                ', N'16-27K·14薪          ', 3, N'分布式存储项目
Java c++ python  人工智能')
INSERT [dbo].[job] ([job_id], [job_name], [pay], [company_id], [introduction]) VALUES (8, N'验证系统设计与开发工程师        ', N'15-30K·14薪          ', 3, N'【岗位职责】
来这里，你将同我们一起拥有”为世界提供最优的计算验证服务“的世界级愿景，设计开发智能化、工具化、服务化的验证系统，采用先进的云服务理念，对测试模型和数据加入大数据学习，AI智能分析的服务处理，成为顶尖的测试专家。你的岗位工作包括不限于：
1、负责华为计算相关产品验证系统方案/场景设计，模块/特性测试设计，兼容性设计与验证，自动化框架设计，测试工具/服务开发，自动化脚本开发；
2、负责计算产品验证系统建模，场景库建设，验证系统开发，产品商用质量评估，提升被测产品精准度，覆盖度和有效性；
3、负责验证系统自动化框架设计开发，负责工具/服务核心算法开发与优化，负责自动化工具/服务生态开放，提升验证效率，验证开放度和验证开放商业变现；
3、负责产品兼容性设计与验证，客户场景比拼和系统调优，负责网上问题紧急处理和长期优化，提升产品交付竞争力和交付质量。 ')
INSERT [dbo].[job] ([job_id], [job_name], [pay], [company_id], [introduction]) VALUES (9, N'算法研究员               ', N'15-25K              ', 3, N'【算法工程师】
我们致力于软件算法的研究设计，通过算法大幅改善产品体验和性能效率
1、可以对单点算法性能做出极致优化，或具备全局视野，能从E2E考虑算法应用竞争力体现；
2、 负责移动终端设备人工智能、大数据挖掘算法和解决方案的研究、设计、验证和交付；
3、 对传感器在专业运动健康、生物识别、情景感知等技术做出优秀的用户体验。')
INSERT [dbo].[job] ([job_id], [job_name], [pay], [company_id], [introduction]) VALUES (10, N'太平洋徐汇旗舰店8K          ', N'8-13K               ', 4, N'【工作职责】
1.通过互联网平台等获取客户资源；
2.负责客户接待、咨询工作，为客户提供专业的房地产职业咨询服务；
3.了解客户需求，根据客户的需求匹配房源，通过线上VR看房，促成二手房买卖或租赁业务，并负责业务跟进和房屋过户手续办理等后续服务工作。')
INSERT [dbo].[job] ([job_id], [job_name], [pay], [company_id], [introduction]) VALUES (11, N'太平洋房屋+8K底薪+就近安排     ', N'12-18K              ', 4, N'工作职责
1，通过网络平台开发获取意向客户，维护客户群体；
2，挖掘客户需求，按客户需求匹配房源，形成带看；
3，促成成交，给客户提供良好的购房/租房体验。
薪资待遇：
1，底薪8000+高额提成，综合收入10000+；
2，租赁业务提成35%，买卖业务提成15-45%；
3，上班地点全上海就近分配，上班便利快捷；
任职要求：
1，年龄18-38，意愿强烈可放宽；
2，学历统招大专及以上，军人优待不限学历！
——太平洋房屋，助你实现价值的平台。')
INSERT [dbo].[job] ([job_id], [job_name], [pay], [company_id], [introduction]) VALUES (12, N'魔都太平洋房屋~ 18-35K     ', N'4-8K                ', 4, N'【任职要求】
1. 大专及以上学历；(退伍军人放宽要求，高中毕业生亦可)
2. 年龄为18-30周岁
3.年轻没有经验但是踏实肯学
4.有销售经验或者同行经验的，愿意心态归零，重新出发
【岗位职责】
1、主要以面谈、网络、电话的方式沟通客户，了解和发掘客户需求，为客户提供专业的置业咨询服务
2、根据客户需求推荐合适房源，陪同客户实地了解房源和介绍沟通
3、为符合意向的客户协调买卖双方关系，达成一致后作为第三方为双方签订房屋买卖合同
4、为客户提供良好的售后服务，维系客户关系')
INSERT [dbo].[job] ([job_id], [job_name], [pay], [company_id], [introduction]) VALUES (13, N'高级企业管理咨询顾问          ', N'15-30K              ', 5, N'基本条件
①年龄：22-32岁，形象气质佳
②学历：本科及以上，工商管理学科优先，如MBA、工商管理、人力资源管理、旅游管理等
岗位要求：有过B端销售团队管理经验
①至少3年以上B端销售经验，且至少有1年销售团队管理经验，团队业绩突出（经常获得冠军者优先）；
②之前的业务模式为主动营销，如面销、提案式为主，且来行动愿意再从一线开始做起；
③有独立开发新大客户能力，身边有年营收5亿以上产值规模的企业家资源者优先。')
INSERT [dbo].[job] ([job_id], [job_name], [pay], [company_id], [introduction]) VALUES (14, N'销售顾问（上市公司+周末双休）     ', N'22-40K              ', 5, N'【具体工作】：
1、通过主动营销模式，为企业家提供企业管理类课程培训及咨询服务；
2、激活老客户并持续跟进服务，达成续单或转介绍；
3、帮助客户解决学习后落地问题，不断发掘客户潜在需求，给客户带来终身价值。
【你需要满足】
1、本科及以上学历，专业不限；在校期间做过社团或学生会部长、主席，有管理部门或团队经验的优先；
2、热爱教育行业，有利爱他人之心；热爱销售，不满足于固定薪资，有野心，肯努力；
3、思维逻辑清晰，有良好的沟通能力和团队协调能力。
【你的作息时间】 每日八小时制，周末双休')
INSERT [dbo].[job] ([job_id], [job_name], [pay], [company_id], [introduction]) VALUES (15, N'大客户经理               ', N'15-30K              ', 5, N'日常工作：
1、B2B，为企业一把手提供管理类商学院课程及咨询服务，完成业绩指标；
2、开发年产值规模在1亿以上的企业客户；
3、持续带教团队1-6人左右；')
INSERT [dbo].[job] ([job_id], [job_name], [pay], [company_id], [introduction]) VALUES (16, N'星巴克咖啡招聘咖啡师          ', N'3-4K                ', 6, N'招募學生兼職，社會兼職，全職
原标题：《星巴克咖啡师》')
INSERT [dbo].[job] ([job_id], [job_name], [pay], [company_id], [introduction]) VALUES (17, N'星巴克咖啡招聘咖啡师          ', N'4-5K·13薪            ', 6, N'星级咖啡师 （全职）
-有一个机会，不仅成为一名员工，更成为星巴克的伙伴-
岗位职责：
•         制作和提供品质如一的饮料、咖啡和食品；
•         与顾客和工作伙伴保持良好的沟通，为所有顾客提供优质的服务；
•         每天执行清洁工作，保持干净和舒适的门店环境和工作环境；
•         负责收银工作和参与现金管理；
•         遵循星巴克营运政策和流程；
任职要求：
•         接受轮班制工作，平均每周工作40小时；
•         优秀的服务意识，能为顾客提供优质的服务；
•         正直诚信，尊重他人，充满热情地做每件事；
•         有餐饮或零售行业工作经验者优先考虑；')
INSERT [dbo].[job] ([job_id], [job_name], [pay], [company_id], [introduction]) VALUES (18, N'星巴克咖啡招聘咖啡师          ', N'150-200元/天          ', 6, N'星级咖啡师 （勤工助学）
-有一个机会，不仅成为一名员工，更成为星巴克的伙伴-
岗位职责：
·         制作和提供品质如一的饮料、咖啡和食品；
·         与顾客和工作伙伴保持良好的沟通，为所有顾客提供优质的服务；
·         每天执行清洁工作，保持干净和舒适的门店环境和工作环境；
·         负责收银工作和参与现金管理；
·         遵循星巴克营运政策和流程；
任职要求：
·         全日制在读学生
·         接受轮班制工作，平均每月能提供80小时以上工时；
·         兼职实习时间半年以上；
·         良好的沟通能力及团队合作能力；
在星巴克，你将获得：
1.​温暖而有归属感的团队氛围
2.​快速晋升机会
3.​成为咖啡大师
4.​有一个机会成就更好的自己
5.​完善的薪酬福利——
a)​早晚班津贴
b)​豆股票/意外医疗保险/伙伴饮料券/伙伴商品折扣/工作期间的免费饮料/伙伴优惠购/节庆福利/门店季度团队基金
原标题：《星巴克咖啡师》')
SET IDENTITY_INSERT [dbo].[job] OFF
GO
SET IDENTITY_INSERT [dbo].[personnels] ON

INSERT [dbo].[personnels] ([personnel_id], [username], [company_id], [password], [telephone], [email], [sex]) VALUES (1, N'zly                 ', 2, N'123456              ', N'19117191007', N'millumc45@mclll.com           ', N'男')
SET IDENTITY_INSERT [dbo].[personnels] OFF
GO
SET IDENTITY_INSERT [dbo].[users] ON

INSERT [dbo].[users] ([user_id], [username], [password], [sex], [email], [telephone]) VALUES (1, N'zly                 ', N'123456              ', N'男', N'1542620762@qq.com             ', N'19117191007')
INSERT [dbo].[users] ([user_id], [username], [password], [sex], [email], [telephone]) VALUES (2, N'wch                 ', N'123456              ', N'男', NULL, NULL)
SET IDENTITY_INSERT [dbo].[users] OFF
GO
ALTER TABLE [dbo].[company] ADD  DEFAULT (N'image/company_icon/default_icon.png') FOR [icon]
GO
ALTER TABLE [dbo].[job]  WITH CHECK ADD  CONSTRAINT [job_company_company_id_fk] FOREIGN KEY([company_id])
REFERENCES [dbo].[company] ([company_id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[job] CHECK CONSTRAINT [job_company_company_id_fk]
GO
ALTER TABLE [dbo].[personnels]  WITH CHECK ADD  CONSTRAINT [personnels_company_company_id_fk] FOREIGN KEY([company_id])
REFERENCES [dbo].[company] ([company_id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[personnels] CHECK CONSTRAINT [personnels_company_company_id_fk]
GO
USE [master]
GO
ALTER DATABASE [RecruitmentSystem] SET  READ_WRITE 
GO
